package cn.com.zzn.services.common;

import cn.com.zzn.common.models.TokenInfo;
import cn.com.zzn.common.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;
import org.joda.time.DateTime;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by cmwin on 10/10/15.
 */
public class AuthServiceImpl implements AuthService {

    private static final String AUDIENCE = "NotReallyImportant";

    private static final String ISSUER = "YourCompanyOrAppNameHere";

    private static final String SIGNING_KEY = "LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";

    @Override
    public String createJsonWebToken(String userId, Long durationDays) {
        //Current time and signing algorithm
        Calendar cal = Calendar.getInstance();
        HmacSHA256Signer signer;
        try {
            signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Configure JSON token
        JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
        token.setAudience(AUDIENCE);
        token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
        token.setExpiration(new org.joda.time.Instant(cal.getTimeInMillis() + 1000L * 60L * 60L * 24L * durationDays));

        //Configure request object, which provides information of the item
        JsonObject request = new JsonObject();
        request.addProperty("userId", userId);

        //-----------------------------------------------
        // TODO : add just for test only begin
        request.addProperty("roles", "admin, manager");
        //-----------------------------------------------

        JsonObject payload = token.getPayloadAsJsonObject();
        payload.add("info", request);

        try {
            return token.serializeAndSign();
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TokenInfo verifyToken(String token) {
        try {
            final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());

            VerifierProvider hmacLocator = new VerifierProvider() {

                @Override
                public List<Verifier> findVerifier(String id, String key){
                    return Lists.newArrayList(hmacVerifier);
                }
            };
            VerifierProviders locators = new VerifierProviders();
            locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
            net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker(){

                @Override
                public void check(JsonObject payload) throws SignatureException {
                    // don't throw - allow anything
                }

            };
            //Ignore Audience does not mean that the Signature is ignored
            JsonTokenParser parser = new JsonTokenParser(locators,
                    checker);
            JsonToken jt;
            try {
                jt = parser.verifyAndDeserialize(token);
            } catch (SignatureException e) {
                throw new RuntimeException(e);
            }
            JsonObject payload = jt.getPayloadAsJsonObject();
            TokenInfo t = new TokenInfo();
            String issuer = payload.getAsJsonPrimitive("iss").getAsString();
            String userIdString =  payload.getAsJsonObject("info").getAsJsonPrimitive("userId").getAsString();
            if (issuer.equals(ISSUER) && !StringUtils.isEmpty(userIdString)) {
                t.setUserId(userIdString);
                t.setIssued(new DateTime(payload.getAsJsonPrimitive("iat").getAsLong()));
                t.setExpires(new DateTime(payload.getAsJsonPrimitive("exp").getAsLong()));
                return t;
            } else {
                return null;
            }
        } catch (InvalidKeyException e1) {
            throw new RuntimeException(e1);
        }
    }
}
