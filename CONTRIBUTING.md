# How to contribute Development of the terasoluna-gfw-functionaltest

This document describes how to contribute the terasoluna-gfw-functionaltest updates.
This project is Java project of [Maven](https://maven.apache.org/).
About running Maven, refer to the [Building a Project with Maven](https://maven.apache.org/run-maven/index.html).

**Contribution procedures are follows:**


## Create a new issue

Create a new issue from [here](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest/issues/new?body=%23%23%20Description%0D%0A%28%2A%2ARequired%2A%2A%3A%20Please%20write%20issue%20description%29%0D%0A%0D%0A%23%23%20Possible%20Solutions%0D%0A%28Optional%3A%20Please%20write%20solutions%20of%20this%20issue%20you%20think%29%0D%0A%0D%0A%23%23%20Affects%20Version%2Fs%0D%0A%28%2A%2ARequired%2A%2A%3A%20Please%20select%20affected%20versions%29%0D%0A%2A%205.0.1.RELEASE%0D%0A%2A%201.0.3.RELEASE%0D%0A%0D%0A%23%23%20Fix%20Version%2Fs%0D%0A%28To%20be%20written%20later%20by%20project%20member%29%0D%0A%0D%0A%23%23%20Issue%20Links%0D%0A%28Optional%3A%20Please%20link%20to%20related%20issues%29%0D%0A%2A%20%23%7Bissue%20no%7D%0D%0A%2A%20or%20external%20url) for contributing(bug report, improvement or new content), and get an issue number(tracking id).

> **Note: Supported language**
>
> English only.

* Write the contribution overview into the title area.
* Write the contribution detail into the comment area.

 e.g.)

 ```
 ## Description
 Support WAS Liberty 8.5 + DB2 as new test environment.

 ## Possible Solutions
 Add configuration files and maven profile for WAS Liberty 8.5 + DB2.

 ## Affects Version/s
 \-

 ## Fix Version/s
 (To be written later by project member)

 ## Issue Links
 N/A
 ```

## Fork a repository

Fork the `terasolunaorg/terasoluna-gfw-functionaltest` into your account repository of GitHub.

* Click a "Fork" button on GitHub web user interface.


## Clone a repository

Clone a forked repository into your local machine.


e.g.)

```console
$ git clone https://github.com/{your account}/terasoluna-gfw-functionaltest.git
```


## Create a work branch

Create a work branch on the master branch into your local repository.

> **Note: Recommended work branch name**
>
> issues/{issue number}_{short description}

e.g.)

```console
$ git checkout master
$ git checkout -b issues/999_support-was8-db2
```

## Modify the terasoluna-gfw-functionaltest

Modify the terasoluna-gfw-functionaltest for contributing.



## Build projects and execute tests

For details, refer to the [How to perform functional test](https://github.com/terasolunaorg/terasoluna-gfw-functionaltest#how-to-perform-functional-test).

If a maven build result has failed, modify a source code again.


## Commit a modification

Commit a modification as follow.

> **Note: Commit comment format**
>
> "{modification overview} #{issue number}"

> **Note: Supported language**
>
> English only.

e.g.)

```console
$ git commit -a -m "Add configuration files and maven profile for WAS 8.5 + DB2 #999"
```


## Push a work branch

Push a work branch to the GitHub.

e.g.)

```console
$ git push origin issues/999_support-was8-db2
```


## Create a pull request

Create a pull request via GitHub web user interface.
For details, refer to the [GitHub document-Creating a pull request-](https://help.github.com/articles/creating-a-pull-request/).

> **Note: Supported language**
>
> English only.

* Write the modification overview into the title area and add the `#{issue number}` at its end. (Default is commit comment or work branch name)
* Write the modification detail into the comment area. (If needed)
* Include the issue number(`#{issue number}` format) to track a modification into the comment area.

e.g.)

| Area | Content | Remark |
| ---- | ------- | ------ |
| Title | Add configuration files and maven profile for WAS 8.5 + DB2 #999 | - |
| Comment | Please review #999 .| If needed, write more informations. |
