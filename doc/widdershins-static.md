---
title: Cake API v1.2.32
language_tabs:
  - java: Java
language_clients:
  - java: ""
toc_footers: []
includes: []
search: false
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="cake-api">Cake API v1.2.32</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

This is a sample of Cake server created using springdocs - a library for OpenAPI 3 with spring boot.

Base URLs:

License: <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache 2.0</a>

# Authentication

- HTTP Authentication, scheme: bearer 

- oAuth2 authentication. For more information, see https://api.slack.com/docs/oauth

    - Flow: authorizationCode
    - Authorization URL = [https://slack.com/oauth/authorize](https://slack.com/oauth/authorize)
    - Token URL = [https://slack.com/api/oauth.access](https://slack.com/api/oauth.access)

|Scope|Scope Description|
|---|---|
|users:read|Read user information|
|im:read|Read messages|

<h1 id="cake-api-other">other</h1>

API with documentation annotations

## Get all cakes

<a id="opIdgetAll_1"></a>

> Code samples

```java
URL obj = new URL("/v1/othercake");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /v1/othercake`

Retrieve all cakes from the server, this is very slow operation since all cakes are baked synchronously, so all of them are made according to their preparation time.

> Example responses

> 200 Response

```json
[
  {
    "name": "cheese cake",
    "prepTimeMin": 60,
    "components": [
      {
        "name": "string",
        "quantity": 0,
        "unit": "string"
      }
    ]
  }
]
```

> 400 Response

<h3 id="get-all-cakes-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<h3 id="get-all-cakes-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[Cake](#schemacake)]|false|none|none|
|» name|string|true|none|Name of the cake.|
|» prepTimeMin|integer(int32)|false|none|Preparation time in minues.|
|» components|[[Ingredient](#schemaingredient)]|true|none|List if ingredients.|
|»» name|string|true|none|none|
|»» quantity|number(double)|true|none|none|
|»» unit|string|true|none|none|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Create cake

<a id="opIdcreateCake_1"></a>

> Code samples

```java
URL obj = new URL("/v1/othercake");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /v1/othercake`

Yummy yummy yummy!

> Body parameter

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

<h3 id="create-cake-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Cake](#schemacake)|false|Body of the request should contain cake definition|

> Example responses

> 400 Response

<h3 id="create-cake-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Find cake by name

<a id="opIdgetCake_1"></a>

> Code samples

```java
URL obj = new URL("/v1/othercake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /v1/othercake/{cake}`

Get recipe of particular cake

<h3 id="find-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|cake|path|string|true|cake name to be retrieved from database|

> Example responses

> 200 Response

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

> 400 Response

<h3 id="find-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|[Cake](#schemacake)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Update cake by name

<a id="opIdupdateCake_1"></a>

> Code samples

```java
URL obj = new URL("/v1/othercake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /v1/othercake/{cake}`

Update the recipe of particular cake

> Body parameter

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

<h3 id="update-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Cake](#schemacake)|false|Body of the request should contain cake definition|

> Example responses

> 400 Response

<h3 id="update-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Delete cake by name

<a id="opIddeleteCake_1"></a>

> Code samples

```java
URL obj = new URL("/v1/othercake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /v1/othercake/{cake}`

I don't know why one might want that!

<h3 id="delete-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|cake|path|string|true|cake name to be retrieved from database|

> Example responses

> 400 Response

<h3 id="delete-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

<h1 id="cake-api-cake">cake</h1>

API with documentation annotations

## Get all cakes

<a id="opIdgetAll"></a>

> Code samples

```java
URL obj = new URL("/v1/cake");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /v1/cake`

Retrieve all cakes from the server, this is very slow operation since all cakes are baked synchronously, so all of them are made according to their preparation time.

> Example responses

> 200 Response

```json
[
  {
    "name": "cheese cake",
    "prepTimeMin": 60,
    "components": [
      {
        "name": "string",
        "quantity": 0,
        "unit": "string"
      }
    ]
  }
]
```

> 400 Response

<h3 id="get-all-cakes-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|Inline|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<h3 id="get-all-cakes-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[Cake](#schemacake)]|false|none|none|
|» name|string|true|none|Name of the cake.|
|» prepTimeMin|integer(int32)|false|none|Preparation time in minues.|
|» components|[[Ingredient](#schemaingredient)]|true|none|List if ingredients.|
|»» name|string|true|none|none|
|»» quantity|number(double)|true|none|none|
|»» unit|string|true|none|none|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Create cake

<a id="opIdcreateCake"></a>

> Code samples

```java
URL obj = new URL("/v1/cake");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /v1/cake`

Yummy yummy yummy!

> Body parameter

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

<h3 id="create-cake-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Cake](#schemacake)|false|Body of the request should contain cake definition|

> Example responses

> 400 Response

<h3 id="create-cake-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Find cake by name

<a id="opIdgetCake"></a>

> Code samples

```java
URL obj = new URL("/v1/cake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /v1/cake/{cake}`

Get recipe of particular cake

<h3 id="find-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|cake|path|string|true|cake name to be retrieved from database|

> Example responses

> 200 Response

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

> 400 Response

<h3 id="find-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|[Cake](#schemacake)|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Update cake by name

<a id="opIdupdateCake"></a>

> Code samples

```java
URL obj = new URL("/v1/cake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /v1/cake/{cake}`

Update the recipe of particular cake

> Body parameter

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}
```

<h3 id="update-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[Cake](#schemacake)|false|Body of the request should contain cake definition|

> Example responses

> 400 Response

<h3 id="update-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

## Delete cake by name

<a id="opIddeleteCake"></a>

> Code samples

```java
URL obj = new URL("/v1/cake/{cake}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /v1/cake/{cake}`

I don't know why one might want that!

<h3 id="delete-cake-by-name-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|cake|path|string|true|cake name to be retrieved from database|

> Example responses

> 400 Response

<h3 id="delete-cake-by-name-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|default response|None|
|400|[Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|default response|[ErrorCodeResponse](#schemaerrorcoderesponse)|

<aside class="warning">
To perform this operation, you must be authenticated by means of one of the following methods:
bearerAuth, authorizationCode
</aside>

# Schemas

<h2 id="tocS_ErrorCodeResponse">ErrorCodeResponse</h2>
<!-- backwards compatibility -->
<a id="schemaerrorcoderesponse"></a>
<a id="schema_ErrorCodeResponse"></a>
<a id="tocSerrorcoderesponse"></a>
<a id="tocserrorcoderesponse"></a>

```json
{
  "code": "string",
  "message": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|code|string|false|none|none|
|message|string|false|none|none|

<h2 id="tocS_Cake">Cake</h2>
<!-- backwards compatibility -->
<a id="schemacake"></a>
<a id="schema_Cake"></a>
<a id="tocScake"></a>
<a id="tocscake"></a>

```json
{
  "name": "cheese cake",
  "prepTimeMin": 60,
  "components": [
    {
      "name": "string",
      "quantity": 0,
      "unit": "string"
    }
  ]
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|Name of the cake.|
|prepTimeMin|integer(int32)|false|none|Preparation time in minues.|
|components|[[Ingredient](#schemaingredient)]|true|none|List if ingredients.|

<h2 id="tocS_Ingredient">Ingredient</h2>
<!-- backwards compatibility -->
<a id="schemaingredient"></a>
<a id="schema_Ingredient"></a>
<a id="tocSingredient"></a>
<a id="tocsingredient"></a>

```json
{
  "name": "string",
  "quantity": 0,
  "unit": "string"
}

```

List if ingredients.

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|none|
|quantity|number(double)|true|none|none|
|unit|string|true|none|none|

