FROM java:8u111-jre-alpine
VOLUME /tmp

ADD build/libs/product-service-*.jar /work/app.jar
ADD run.sh /

ENTRYPOINT ["/run.sh"]
