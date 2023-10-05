# Feedback Form API


```
curl -X POST -i \
-H 'Content-Type: application/json' \
-d "{\"rating\":\"2\"}" \
http://localhost:8080/feedback
```

## Create Keystore

save ca.crt from kafka-cluster to file
```
oc get secret -n feedback-app dev-feedback-app-messaging-cluster-ca-cert -o jsonpath='{.data.ca\.crt}' | base64 -d > ca.crt
```

import ca.crt to truststore
```
keytool -import -trustcacerts -alias kafka -file ca.crt -keystore clientkeystore.jks
```

create secret 
```
oc create secret generic kafka-keystore --from-file=clientkeystore.jks
``````