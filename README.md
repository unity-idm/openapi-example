# Generation of OpanAPI specification based on Spring REST Controllers.
Maven project with an example how the OpenAPI spec can be generated based on implementation.
It provides also the information on how static documentation can be generated based on the spec.

## Example based on [springdoc](https://springdoc.org/)

### Run the application
* Run application using `mvn spring-boot:run -Pspringdoc`
* Open `http://localhost:8080/swagger-ui.html` in browser

### Generate OpenAPI description in json
* Run application using `mvn install -Pspringdoc`
* Output file is in `target/openapi.json`


## HTML document generation based on OpenAPI spec
Example made with help of [ReDoc](https://github.com/Redocly/redoc)

HTML doc generated for this project [redoc-example](./doc/redoc-static.html)

### Prerequesites
* Install Node.js
* Install redoc-cli. Run `npm install -g redoc-cli`

### Generate documentation
* Generate `openapi.json` for the project
* Run `redoc-cli bundle target/openapi.json --options.hideHostname=true`
* Open `redoc-static.html` in browser


## Markdown document generation based on OpenAPI spec
Example made with help of [widdershins](https://github.com/Mermade/widdershins)

MD doc generated for this project [widdershins-example](./doc/widdershins-static.md)

### Prerequesites
* Install Node.js
* Install widdershins. Run `npm install -g widdershins`

### Generate documentation
* Generate `openapi.json` for the project
* Run `node widdershins --search false --language_tabs 'java:Java' --summary target/openapi.json -o doc/widdershins-static.md`
* Open `doc/widdershins-static.md` in markdown viewer.

## PDF document generation based on OpenAPI spec

Example made with help of [RapiPdf](https://mrin9.github.io/RapiPdf/)

Open `doc/RapiPDF.html` in browser and click GENERATE PDF.

