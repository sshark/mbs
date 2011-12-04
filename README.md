# Multi boxes selection
## Changelog :
### v.1.0: September 14th 2011 - Initial release
### v.1.0-SNAPSHOT: December 4th 2011 - Convert to a common demo showcase web application

## License

Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0] (http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Summary

Multi boxes selection is a Wicket widget. It uses [jQuery] (http://www.jquery.com) via [wiQuery] (http://code.google.com/p/wiquery). It is an input widget in a form of boxes. The users choose by clicking on the boxes and submit to make his choice final. The widget is configurable to accept minimum selections and prevent selections beyond the maximum limit.

This widget serves 2 purposes,

1) use as it is.
2) how-to for implementing Wicket components using wiQuery.

## Demo

In project root,

1. mvn install 
2. cd widget-demo
3. mvn jetty:run
4. Log on to [http://localhost:8080/demo/] (http://localhost:8080/demo/)

Do not run mvn install on base directory unless you want to install both mbs-core and mbs-demo to your Maven repository.

Lim, Teck Hooi
