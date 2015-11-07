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

The application is then available under 
> http://localhost:5000/hash (POST)
> http://localhost:5000/saltedhash (POST)
> http://localhost:5000/generate (GET)

The first two calls generate a cryptographic hash corresponding to the body sent to the API, with or without using the salt.
The third call gives a sample list of well-known hash values, to be completed as an exercise for the students.

## Notes
One can check the corresponding result, and even try and revert the hash, by using a site like https://md5hashing.net
