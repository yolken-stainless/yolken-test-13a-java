# Yolken Test 13a Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.configure_me_yolken_test_13a.api/yolken-test-13a-java)](https://central.sonatype.com/artifact/com.configure_me_yolken_test_13a.api/yolken-test-13a-java/0.0.1)
[![javadoc](https://javadoc.io/badge2/com.configure_me_yolken_test_13a.api/yolken-test-13a-java/0.0.1/javadoc.svg)](https://javadoc.io/doc/com.configure_me_yolken_test_13a.api/yolken-test-13a-java/0.0.1)

<!-- x-release-please-end -->

The Yolken Test 13a Java SDK provides convenient access to the [Yolken Test 13a REST API](http://example.com) from applications written in Java.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [example.com](http://example.com). Javadocs are available on [javadoc.io](https://javadoc.io/doc/com.configure_me_yolken_test_13a.api/yolken-test-13a-java/0.0.1).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.CONFIGURE_ME_yolken_test_13a.api:yolken-test-13a-java:0.0.1")
```

### Maven

```xml
<dependency>
  <groupId>com.CONFIGURE_ME_yolken_test_13a.api</groupId>
  <artifactId>yolken-test-13a-java</artifactId>
  <version>0.0.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;
import com.configure_me_yolken_test_13a.api.models.Order;
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;

// Configures using the `yolkentest13a.petstoreApiKey` and `yolkentest13a.baseUrl` system properties
// Or configures using the `PETSTORE_API_KEY` and `YOLKEN_TEST_13A_BASE_URL` environment variables
YolkenTest13aClient client = YolkenTest13aOkHttpClient.fromEnv();

Order order = client.store().orders().create();
```

## Client configuration

Configure the client using system properties or environment variables:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

// Configures using the `yolkentest13a.petstoreApiKey` and `yolkentest13a.baseUrl` system properties
// Or configures using the `PETSTORE_API_KEY` and `YOLKEN_TEST_13A_BASE_URL` environment variables
YolkenTest13aClient client = YolkenTest13aOkHttpClient.fromEnv();
```

Or manually:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    // Configures using the `yolkentest13a.petstoreApiKey` and `yolkentest13a.baseUrl` system properties
    // Or configures using the `PETSTORE_API_KEY` and `YOLKEN_TEST_13A_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter    | System property                | Environment variable       | Required | Default value                           |
| --------- | ------------------------------ | -------------------------- | -------- | --------------------------------------- |
| `apiKey`  | `yolkentest13a.petstoreApiKey` | `PETSTORE_API_KEY`         | true     | -                                       |
| `baseUrl` | `yolkentest13a.baseUrl`        | `YOLKEN_TEST_13A_BASE_URL` | true     | `"https://petstore3.swagger.io/api/v3"` |

System properties take precedence over environment variables.

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;

YolkenTest13aClient clientWithOptions = client.withOptions(optionsBuilder -> {
    optionsBuilder.baseUrl("https://example.com");
    optionsBuilder.maxRetries(42);
});
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Yolken Test 13a API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.store().orders().create(...)` should be called with an instance of `OrderCreateParams`, and it will return an instance of `Order`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;
import com.configure_me_yolken_test_13a.api.models.Order;
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `yolkentest13a.petstoreApiKey` and `yolkentest13a.baseUrl` system properties
// Or configures using the `PETSTORE_API_KEY` and `YOLKEN_TEST_13A_BASE_URL` environment variables
YolkenTest13aClient client = YolkenTest13aOkHttpClient.fromEnv();

CompletableFuture<Order> order = client.async().store().orders().create();
```

Or create an asynchronous client from the beginning:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClientAsync;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClientAsync;
import com.configure_me_yolken_test_13a.api.models.Order;
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;
import java.util.concurrent.CompletableFuture;

// Configures using the `yolkentest13a.petstoreApiKey` and `yolkentest13a.baseUrl` system properties
// Or configures using the `PETSTORE_API_KEY` and `YOLKEN_TEST_13A_BASE_URL` environment variables
YolkenTest13aClientAsync client = YolkenTest13aOkHttpClientAsync.fromEnv();

CompletableFuture<Order> order = client.store().orders().create();
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Raw responses

The SDK defines methods that deserialize responses into instances of Java classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```java
import com.configure_me_yolken_test_13a.api.core.http.Headers;
import com.configure_me_yolken_test_13a.api.core.http.HttpResponseFor;
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryParams;
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryResponse;

HttpResponseFor<StoreListInventoryResponse> response = client.store().withRawResponse().listInventory();

int statusCode = response.statusCode();
Headers headers = response.headers();
```

You can still deserialize the response into an instance of a Java class if needed:

```java
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryResponse;

StoreListInventoryResponse parsedResponse = response.parse();
```

## Error handling

The SDK throws custom unchecked exception types:

- [`YolkenTest13aServiceException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                                                 |
  | ------ | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/UnexpectedStatusCodeException.kt) |

- [`YolkenTest13aIoException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aIoException.kt): I/O networking errors.

- [`YolkenTest13aRetryableException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aRetryableException.kt): Generic error indicating a failure that could be retried by the client.

- [`YolkenTest13aInvalidDataException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`YolkenTest13aException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `YOLKEN_TEST_13A_LOG` environment variable to `info`:

```sh
export YOLKEN_TEST_13A_LOG=info
```

Or to `debug` for more verbose logging:

```sh
export YOLKEN_TEST_13A_LOG=debug
```

## ProGuard and R8

Although the SDK uses reflection, it is still usable with [ProGuard](https://github.com/Guardsquare/proguard) and [R8](https://developer.android.com/topic/performance/app-optimization/enable-app-optimization) because `yolken-test-13a-java-core` is published with a [configuration file](yolken-test-13a-java-core/src/main/resources/META-INF/proguard/yolken-test-13a-java-core.pro) containing [keep rules](https://www.guardsquare.com/manual/configuration/usage).

ProGuard and R8 should automatically detect and use the published rules, but you can also manually copy the keep rules if necessary.

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`YolkenTest13aOkHttpClient`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClient.kt) or [`YolkenTest13aOkHttpClientAsync`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff between requests.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a request.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryResponse;

StoreListInventoryResponse response = client.store().listInventory(RequestOptions.builder().timeout(Duration.ofSeconds(30)).build());
```

Or configure the default for all method calls at the client level:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;
import java.time.Duration;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

### HTTPS

> [!NOTE]
> Most applications should not call these methods, and instead use the system defaults. The defaults include
> special optimizations that can be lost if the implementations are modified.

To configure how HTTPS connections are secured, configure the client using the `sslSocketFactory`, `trustManager`, and `hostnameVerifier` methods:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .fromEnv()
    // If `sslSocketFactory` is set, then `trustManager` must be set, and vice versa.
    .sslSocketFactory(yourSSLSocketFactory)
    .trustManager(yourTrustManager)
    .hostnameVerifier(yourHostnameVerifier)
    .build();
```

### Custom HTTP client

The SDK consists of three artifacts:

- `yolken-test-13a-java-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`YolkenTest13aClient`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClient.kt), [`YolkenTest13aClientAsync`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientAsync.kt), [`YolkenTest13aClientImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientImpl.kt), and [`YolkenTest13aClientAsyncImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientAsyncImpl.kt), all of which can work with any HTTP client
- `yolken-test-13a-java-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`YolkenTest13aOkHttpClient`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClient.kt) and [`YolkenTest13aOkHttpClientAsync`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClientAsync.kt), which provide a way to construct [`YolkenTest13aClientImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientImpl.kt) and [`YolkenTest13aClientAsyncImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientAsyncImpl.kt), respectively, using OkHttp
- `yolken-test-13a-java`
  - Depends on and exposes the APIs of both `yolken-test-13a-java-core` and `yolken-test-13a-java-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`yolken-test-13a-java` dependency](#installation) with `yolken-test-13a-java-core`
2. Copy `yolken-test-13a-java-client-okhttp`'s [`OkHttpClient`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`YolkenTest13aClientImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientImpl.kt) or [`YolkenTest13aClientAsyncImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientAsyncImpl.kt), similarly to [`YolkenTest13aOkHttpClient`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClient.kt) or [`YolkenTest13aOkHttpClientAsync`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`yolken-test-13a-java` dependency](#installation) with `yolken-test-13a-java-core`
2. Write a class that implements the [`HttpClient`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/core/http/HttpClient.kt) interface
3. Construct [`YolkenTest13aClientImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientImpl.kt) or [`YolkenTest13aClientAsyncImpl`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/YolkenTest13aClientAsyncImpl.kt), similarly to [`YolkenTest13aOkHttpClient`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClient.kt) or [`YolkenTest13aOkHttpClientAsync`](yolken-test-13a-java-client-okhttp/src/main/kotlin/com/configure_me_yolken_test_13a/api/client/okhttp/YolkenTest13aOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.configure_me_yolken_test_13a.api.core.JsonValue;
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;

OrderCreateParams params = OrderCreateParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/core/Values.kt) object to its setter:

```java
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;

OrderCreateParams params = OrderCreateParams.builder().build();
```

The most straightforward way to create a [`JsonValue`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/core/Values.kt) is using its `from(...)` method:

```java
import com.configure_me_yolken_test_13a.api.core.JsonValue;
import java.util.List;
import java.util.Map;

// Create primitive JSON values
JsonValue nullValue = JsonValue.from(null);
JsonValue booleanValue = JsonValue.from(true);
JsonValue numberValue = JsonValue.from(42);
JsonValue stringValue = JsonValue.from("Hello World!");

// Create a JSON array value equivalent to `["Hello", "World"]`
JsonValue arrayValue = JsonValue.from(List.of(
  "Hello", "World"
));

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
JsonValue objectValue = JsonValue.from(Map.of(
  "a", 1,
  "b", 2
));

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
JsonValue complexValue = JsonValue.from(Map.of(
  "a", List.of(
    1, 2
  ),
  "b", List.of(
    3, 4
  )
));
```

Normally a `Builder` class's `build` method will throw [`IllegalStateException`](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) if any required parameter or property is unset.

To forcibly omit a required parameter or property, pass [`JsonMissing`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/core/Values.kt):

```java
import com.configure_me_yolken_test_13a.api.core.JsonMissing;
import com.configure_me_yolken_test_13a.api.models.pets.Pet;
import com.configure_me_yolken_test_13a.api.models.pets.PetCreateParams;
import com.configure_me_yolken_test_13a.api.models.store.orders.OrderCreateParams;

OrderCreateParams params = PetCreateParams.builder()
    .pet(Pet.builder()
        .name("doggie")
        .addPhotoUrl("string")
        .build())
    .name(JsonMissing.of())
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.configure_me_yolken_test_13a.api.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.store().orders().create(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.configure_me_yolken_test_13a.api.core.JsonField;
import java.util.Optional;

JsonField<Object> field = client.store().orders().create(params)._field();

if (field.isMissing()) {
  // The property is absent from the JSON response
} else if (field.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = field.asString();

  // Try to deserialize into a custom type
  MyClass myObject = field.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`YolkenTest13aInvalidDataException`](yolken-test-13a-java-core/src/main/kotlin/com/configure_me_yolken_test_13a/api/errors/YolkenTest13aInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.configure_me_yolken_test_13a.api.models.Order;

Order order = client.store().orders().create(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.configure_me_yolken_test_13a.api.models.Order;

Order order = client.store().orders().create(RequestOptions.builder().responseValidation(true).build());
```

Or configure the default for all method calls at the client level:

```java
import com.configure_me_yolken_test_13a.api.client.YolkenTest13aClient;
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient;

YolkenTest13aClient client = YolkenTest13aOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/yolken-stainless/yolken-test-13a-java/issues) with questions, bugs, or suggestions.
