# Functional Test of TERASOLUNA Server Framework for Java (5.x) Common Library
This project provides functional tests of [TERASOLUNA Server Framework for Java (5.x) Common Library](https://github.com/terasolunaorg/terasoluna-gfw).

[![Build Status](https://travis-ci.org/terasolunaorg/terasoluna-gfw-functionaltest.png?branch=master)](https://travis-ci.org/terasolunaorg/terasoluna-gfw-functionaltest)

## How to contribute
**Contributing (bug report, pull request, any comments etc.) is welcome !!** Please see the [contributing guideline](CONTRIBUTING.md) for details.

## Test case design

Test case scenarios are managed at [wiki pages](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki).

> **Note:**
>
> Currently, support language is Japanese only. (Will translate to English as soon as possible)

## Tested environments at the time of release

Tested environments are managed at [wiki page](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment).

## How to perform functional test

**Preconditions are as follow:**

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [JDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) installed (`JAVA_HOME` defined as environment variable)
* [Maven](https://maven.apache.org/download.cgi) installed (Can run `mvn` command)
* Firefox([for personal](https://www.mozilla.org/en-US/firefox/all/) or [ESR](https://www.mozilla.org/en-US/firefox/organizations/all/)) installed (ESR is used on our CI environment)
* [geckodriver](https://github.com/mozilla/geckodriver/releases) (`v0.14.0` recommended) placed in application execution environment and add to `PATH`.

### [Step 1] Create database of PostgreSQL (Optional)
If [PostgreSQL](http://www.postgresql.org/) use as database , you need to create database of PostgreSQL into local machine. (PostgreSQL can download via [here site](http://www.postgresql.org/download/)).

> **Note:**
>
> If [H2](http://www.h2database.com/) use as database, you can skip this step.

#### Download & install
By default, database owner is `postgres` user, and password of `postgres` user is `'P0stgres'`.

#### Create database
```console
$ createdb -U postgres terasoluna-gfw-functionaltest --locale=C --encoding=UTF8 --template=template0
```

### [Step 2] Clone a repository
Clone the `terasolunaorg/terasoluna-gfw-functionaltest` repository into local machine.

```console
$ git clone https://github.com/terasolunaorg/terasoluna-gfw-functionaltest.git
```

### [Step 3] Build artifacts
Build artifacts using maven commands as follows.

#### Case that use embedded H2 as database

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web
```

> **Note:**
>
> When using JDK 7, build as follows.
> you must compile with the target version 1.7 in accordance with the runtime environment JVM.
> You can set the target version using `java-version` property.
> ```console
> $ mvn -U install -am -pl terasoluna-gfw-functionaltest-web -Djava-version=1.7
> ```

#### Case that use PostgreSQL as database

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web -P tomcat8-postgresql,warpack-env,warpack-jstl,travis
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should modify settings in `terasoluna-gfw-functionaltest-env/configs/travis/ContainerConfigXML/context.xml`.

### [Step 4] Initialize database (Optional)
If PostgreSQL use as database, initialize database before run functional test.

```console
$ mvn -U sql:execute -pl terasoluna-gfw-functionaltest-initdb
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should specify `-Ddb.username={your user}` or `-Ddb.password={your password}` or both.

### [Step 5] Startup Tomcat8 and deploy war file
Startup Tomcat8 and deploy war file using [CARGO maven plugin](https://codehaus-cargo.github.io/cargo/Maven2+plugin.html).

#### Case that use embedded H2 as database

```console
$ cd {your repository directory}
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web
```

#### Case that use PostgreSQL as database (use Tomcat JNDI Resource)

```console
$ cd {your repository directory}
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web -P travis
```

> **Note:**
>
> Shutdown trigger is "Ctrl + C" on console.

### [Step 6] Run functional tests
Run tests using Selenium(`WebDriver`) on JUnit.

```console
$ cd {your repository directory}
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium
```

> **Note:**
>
> If functional test is failed, try again using latest Selenium(specify with `-Dselenium.version={latest version}`).
> Please also refer [tested environment](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment) for more information about our tested environment. At last, please check [selenium changelog](https://github.com/SeleniumHQ/selenium/blob/master/java/CHANGELOG) to make sure your Firefox version is supported.

> **Note:**
>
> When using JDK 7,  please build as follows.
>```console
> $ mvn -U test -pl terasoluna-gfw-functionaltest-selenium -Djava-version=1.7
>```

> **Note:**
>
> If GeckoDriver is not registered in the path, [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) will download it automatically.  
> If required proxy, please set `selenium.proxyHttpServer`.  
> If required proxy authentication, set   `selenium.proxyUserName`, `selenium.proxyUserPassword`.  
> ```console
> $ mvn -U test -pl terasoluna-gfw-functionaltest-selenium -Dselenium.proxyHttpServer={HttpServer} -Dselenium.proxyUserName={UserName} -Dselenium.proxyUserPassword={Password}
> ```  

> **Note:**
> You can change GeckoDriver's version with setting `selenium.geckodriverVersion`.


## Appendix

### How to use latest or any branch snapshot of Common Library

If latest or any branch snapshot of Common Library want to use, install latest or any branch snapshot before build and test.

#### Clone terasoluna-gfw repository into local machine

```console
$ git clone https://github.com/terasolunaorg/terasoluna-gfw.git
```

#### Install latest or any branch snapshot of Common Library into local machine

```console
$ cd {your repository directory of terasoluna-gfw}
$ git checkout {target branch}
$ mvn clean install
```
