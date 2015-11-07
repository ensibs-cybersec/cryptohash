package ensibs;

import static spark.Spark.*;
import org.apache.commons.codec.digest.DigestUtils;

public class SHA256test {

    public static void main(String[] args) {
        setPort(5000);

        final String startSalt = System.getenv("STARTSALT");
        final String endSalt = System.getenv("ENDSALT");

        post("/hash", (request, response) -> {
	    final String stringText = request.body();
	    return DigestUtils.sha256Hex(stringText);
        });

        post("/saltedhash", (request, response) -> {
	    final String stringText = request.body();
	    if (startSalt == null || startSalt.length() == 0) {
		System.out.println("ERROR : no salt value has been set in environment variable STARTSALT");
		return "ERROR";
	    }
	    if (endSalt == null || endSalt.length() == 0) {
		System.out.println("ERROR : no salt value has been set in environment variable ENDSALT");
		return "ERROR";
	    }
	    return DigestUtils.sha256Hex(startSalt + stringText + endSalt);
        });
	
	get("/generate", (request, response) -> {
	    response.type("application/json");
	    return "[{ \"mode\": \"SHA-256\", \"value\": \"admin\", \"hash\": \"8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918\" },"
		+ "{ \"mode\": \"MD5\", \"value\": \"password\", \"hash\": \"5f4dcc3b5aa765d61d8327deb882cf99\" }]";
	});
    }
}
