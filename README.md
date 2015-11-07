# cryptohash
This sample application shows how to manipulate a cryptographic hash in Java

## Architecture
The application is composed with a Docker image

## Use
Easiest way to run the application is to start a Docker container:

    git clone https://github.com/ensibs-cybersec/cryptohash.git
    cd cryptohash
    docker build -t cryptohash .
    docker run -d -p 5000:5000 -e STARTSALT=RandomSaltToPrefixPassword -e ENDSALT=RandomSaltToSuffixPassword cryptohash

The application is then available using a browser or a tool like Postman

> http://localhost:5000/hash (POST)

This call generates a cryptographic hash corresponding to the body sent to the API.

> http://localhost:5000/saltedhash (POST)

This call generates a cryptographic hash corresponding to the body sent to the API, using the salt.

> http://localhost:5000/generate (GET)

This call gives a sample list of well-known hash values, to be completed as an exercise for the students. The result is output as a JSON content.

## Notes
One can check the corresponding result, and even try and revert the hash, by using a site like https://md5hashing.net
