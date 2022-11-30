# feedback-form Project

## SSO Testing

[Quarkus Guide](https://quarkus.io/guides/security-openid-connect#starting-and-configuring-the-keycloak-server)

Go to http://localhost:8080/q/dev/io.quarkus.quarkus-oidc/provider and check host and port of dev services keycloak instance.
```
export access_token=$(\
curl --insecure -X POST http://localhost:58822/realms/quarkus/protocol/openid-connect/token \
--user backend-service:secret \
-H 'content-type: application/x-www-form-urlencoded' \
-d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token' \
)
```

Check authentication: 

```
curl -X POST -i \
-H 'Content-Type: application/json' \
-d "{\"rating\":\"2\"}" \
http://localhost:8080/feedback \
-H "Authorization: Bearer "$access_token
```

And the log should tell you something like 

`[cli.kla.fee.FeedbackResource] (executor-thread-0) Feedback form got rating: Feedback(rating=2) from user User(userName=alice)`

or 

```
HTTP/1.1 401 Unauthorized
www-authenticate: Bearer
content-length: 0
```

if you are not authorized.