# Functional Test of TERASOLUNA Server Framework for Java (5.x) Common Library
This project provides functional tests of [TERASOLUNA Server Framework for Java (5.x) Common Library](https://github.com/terasolunaorg/terasoluna-gfw).

## How to contribute
**Contributing (bug report, pull request, any comments etc.) is welcome !!** Please see the [contributing guideline](CONTRIBUTING.md) for details.

## Test case design

Test case scenarios are managed at [docs](./docs/).

> **Note:**
>
> Currently, support language is Japanese only.

## Tested environments at the time of release

Tested environments are managed at [wiki page](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment).

## How to perform functional test

**Preconditions are as follow:**

* [JDK 17](https://developers.redhat.com/products/openjdk/download) installed (`JAVA_HOME` defined as environment variable)
* [Maven](https://maven.apache.org/download.cgi) installed (Can run `mvn` command)
* Firefox([for personal](https://www.mozilla.org/en-US/firefox/all/) or [ESR](https://www.mozilla.org/en-US/firefox/organizations/all/)) installed (ESR is used on our CI environment)

### [Step 1] Create database of PostgreSQL (Optional)
If [PostgreSQL](http://www.postgresql.org/) use as database , you need to create database of PostgreSQL into local machine. (PostgreSQL can download via [here site](http://www.postgresql.org/download/)).

> **Note:**
>
> If [H2](http://www.h2database.com/) use as database, you can skip this step.

#### Download & install
By default, database owner is `postgres` user, and password of `postgres` user is `'P0stgres'`.

#### Create database
```console
$ createdb -U postgres --locale=C --encoding=UTF8 --template=template0 terasoluna-gfw-functionaltest
```

### [Step 2] Clone a repository
Clone the `terasolunaorg/terasoluna-gfw-functionaltest` repository into local machine.

```console
$ git clone https://github.com/terasolunaorg/terasoluna-gfw-functionaltest.git
```

### [Step 3] Build artifacts
Build artifacts using maven commands as follows.

#### Case that use embedded H2 as database

The commands are different for XML-based configuration and Java-based configuration.

**XML-based configuration**

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ cd {your repository directory}/XmlConfig
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web
```

**Java-based configuration**

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ cd {your repository directory}/JavaConfig
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web
```

#### Case that use PostgreSQL as database

The commands are different for XML-based configuration and Java-based configuration.

**XML-based configuration**

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ cd {your repository directory}/XmlConfig
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web -P tomcat10-postgresql,include-context,compile-env
```

**Java-based configuration**

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ cd {your repository directory}/JavaConfig
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web -P tomcat10-postgresql,include-context,compile-env
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should modify settings in `terasoluna-gfw-functionaltest-env/configs/local/ContainerConfigXML/context.xml`.

### [Step 4] Initialize database (Optional)
If PostgreSQL use as database, initialize database before run functional test.

```console
$ mvn -U sql:execute -pl terasoluna-gfw-functionaltest-initdb
```

> **Note:**
>
> If you not use default user(`postgres`) or password(`P0stgres`), you should specify `-Ddb.username={your user}` or `-Ddb.password={your password}` or both.

### [Step 5] Startup Tomcat10 and deploy war file
Startup Tomcat10 and deploy war file using [CARGO maven plugin](https://codehaus-cargo.github.io/cargo/Maven+3+Plugin.html).

The commands are different for XML-based configuration and Java-based configuration.

**XML-based configuration**

```console
$ cd {your repository directory}/XmlConfig
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web
```

**Java-based configuration**

```console
$ cd {your repository directory}/JavaConfig
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web
```

> **Note:**
>
> Shutdown trigger is "Ctrl + C" on console.

### [Step 6] Run functional tests
Run tests using Selenium(`WebDriver`) on JUnit.

The commands are different for XML-based configuration and Java-based configuration.

**XML-based configuration**

```console
$ cd {your repository directory}/XmlConfig
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium
```

**Java-based configuration**

```console
$ cd {your repository directory}/JavaConfig
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium
```

The following options can be set at selenium runtime.

Please use them according to the situation.

If you do not specify any options, firefox (the latest driver) & headless mode will be used.

| Option | Overview | Value that can be set | Default value | Setting example
| ---- | ---- | ---- | ---- | ---- |
| wdm.cachePath | Directory where web driver is downloaded | Any directory | /.cache/selenium | -Dwdm.cachePath=/opt/geckodriver |
| wdm.geckoDriverVersion | Version of geckoDriver | [Version](https://github.com/mozilla/geckodriver/releases) | Latest version | -Dwdm.geckoDriverVersion=0.32.0 |
| selenium.headless | Headless | true, false | true | -Dselenium.headless=false |
| cargo.maven.containerUrl | container URL for Cargo | [Tomcat](https://archive.apache.org/dist/tomcat/) | URL corresponding to the version of Tomcat set in parent of | -Dcargo.maven.containerUrl=[https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.33/bin/apache-tomcat-10.1.33.zip](https://archive.apache.org/dist/tomcat/tomcat-10/v10.1.33/bin/apache-tomcat-10.1.33.zip) |

> **Note:**
>
> If functional test is failed, try again using latest Selenium(specify with `-Dselenium.version={latest version}`).
> Please also refer [tested environment](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment) for more information about our tested environment. At last, please check [selenium changelog](https://github.com/SeleniumHQ/selenium/blob/master/java/CHANGELOG) to make sure your Firefox version is supported.

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

### Project configuration description

```
terasoluna-gfw-functionaltest
├─JavaConfig
│  ├─terasoluna-gfw-functionaltest-domain
│  ├─terasoluna-gfw-functionaltest-env
│  ├─terasoluna-gfw-functionaltest-initdb
│  ├─terasoluna-gfw-functionaltest-selenium
│  └─terasoluna-gfw-functionaltest-web
└─XmlConfig
    ├─terasoluna-gfw-functionaltest-domain
    ├─terasoluna-gfw-functionaltest-env
    ├─terasoluna-gfw-functionaltest-initdb
    ├─terasoluna-gfw-functionaltest-selenium
    └─terasoluna-gfw-functionaltest-web
```

This project is divided and managed in two directories: XML-based configuration and Java-based configuration.

The project configurations under XML-based configuration and Java-based configuration are the same.

- **terasoluna-gfw-functionaltest-domain**

  A project that stores classes and configuration files related to the domain layer

- **terasoluna-gfw-functionaltest-env**

  A project that stores environment-dependent files, etc.

- **terasoluna-gfw-functionaltest-initdb**

  A project that manages the SQL file for initializing the database

- **terasoluna-gfw-functionaltest-selenium**

  Project to manage Selenium tests

- **terasoluna-gfw-functionaltest-web**

  A project that stores classes and configuration files related to the application layer
