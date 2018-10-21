---
title: "ClojureCL: Community"
layout: article
---

## Where to contact me

~~[I hang around at Slack Clojurians Uncomplicate](https://clojurians.slack.com/messages/uncomplicate/details/)~~
<p><a href="https://patreon.com/draganrocks">Please support my work on Patreon</a>. I'll intive you to a dedicated <a href="https://discordapp.com">Discord</a> discussion server. Can't afford to donate? Ask for a free invite.</p>

[ClojureCL has a mailing list](https://groups.google.com/forum/#!forum/uncomplicate). Feel free to join it and ask any questions you may have.

[Follow my blog at dragan.rocks](https://dragan.rocks) to keep up with the development and tutorials.

## News & Announcements on Twitter

To subscribe for announcements of releases, important changes and so on, please follow [@Uncomplicateorg](https://twitter.com/#!/uncomplicateorg) on Twitter.

## What is Uncomplicate?

A collection of Clojure libraries, currently containing:

* [ClojureCL](https://clojurecl.uncomplicate.org) - you are reading about it.
* [ClojureCUDA](https://clojurecl.uncomplicate.org) - Rimilar to ClojureCL, but uses Nvidia's CUDA (for better and for worse).
* [Neanderthal](https://neanderthal.uncomplicate.org) - Fast matrix computations and linear algebra in Clojure (CPU and GPU).
* [Fluokitten](https://fluokitten.uncomplicate.org) - Category Theory in idiomatic Clojure.

## Get Involved

I welcome anyone who is willing to contribute, no mather the level of experience. Please contact me through the [Uncomplicate mailing list](https://groups.google.com/forum/#!forum/uncomplicate).
Here are some ways in which you can help:

## Help with the Technical Writing

* If you are a native English speaker, i would really appreciate if you can help with correcting the English on the ClojureCL site and in the  documentation.
* Contribute your example code to be added to ClojureCL tests.
* Contribute articles and tutorials.

The source code of the site is [here](https://github.com/uncomplicate/clojurecl/tree/gh-pages). Please fork it on GitHub, make your changes, and issue a pull request, or simply contact us through the mailing list to see what is your preferred means of sending the changes.

## Report Issues

* Do code review of the ClojureCL code and suggest improvements.
* If you find a bug, a poor default, a missing feature or find any part of the API inconvenient, please [file an issue](https://github.com/uncomplicate/clojurecl/issues) on Github.
If possible, try to explain what behavior you expected and why. Bonus points for contributing failing test cases.

## Contribute Code

ClojuceCL uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make sure you have it installed and then run tests against supported Clojure versions using

    lein midje

Then create a branch and make your changes on it. Once you are done with your changes and all tests pass, submit a pull request on Github.
