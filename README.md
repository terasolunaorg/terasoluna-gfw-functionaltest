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

* [JDK 8 +](https://developers.redhat.com/products/openjdk/download) installed (`JAVA_HOME` defined as environment variable)
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
> If you are using JDK11 to JDK21, please specify explicitly the include-context of the default profile since the jdk profile is enabled. jdk profile is a necessary setting when launching cargo and generating javadoc.
>
> mvn -U install -am -pl terasoluna-gfw-functionaltest-web -P include-context,compile-env

#### Case that use PostgreSQL as database

```console
$ cd {your repository directory}
$ git checkout {target branch}
$ mvn -U install -am -pl terasoluna-gfw-functionaltest-web -P tomcat9-postgresql,include-context,compile-env
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

### [Step 5] Startup Tomcat9 and deploy war file
Startup Tomcat9 and deploy war file using [CARGO maven plugin](https://codehaus-cargo.github.io/cargo/Maven+3+plugin.html).

```console
$ cd {your repository directory}
$ mvn -U cargo:run -pl terasoluna-gfw-functionaltest-web
```

> **Note:**
>
> Shutdown trigger is "Ctrl + C" on console.

### [Step 6] Run functional tests
Run tests using Selenium(`WebDriver`) on JUnit.

```console
$ cd {your repository directory}
$ mvn -U test -pl terasoluna-gfw-functionaltest-selenium -Dwdm.cachePath=/opt/geckodriver -Dwdm.geckoDriverVersion=0.32.0
```

> **Note:**
>
> If functional test is failed, try again using latest Selenium(specify with `-Dselenium.version={latest version}`).
> Please also refer [tested environment](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/wiki/Tested-Environment) for more information about our tested environment. At last, please check [selenium changelog](https://github.com/SeleniumHQ/selenium/blob/master/java/CHANGELOG) to make sure your Firefox version is supported.

> **Note:**
>
> By default, [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) will download the latest [geckodriver](https://github.com/mozilla/geckodriver/releases) to `~/.cache/selenium` automatically.
> If you want to specify the download destination directory, please specify "`-Dwdm.cachePath`" in the startup argument.
> To specify the version of geckoDriver, specify "`-Dwdm.geckoDriverVersion`" in the startup argument.
>
> See [advanced-configuration](https://bonigarcia.dev/webdrivermanager/#advanced-configuration) for details on configuration.

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
