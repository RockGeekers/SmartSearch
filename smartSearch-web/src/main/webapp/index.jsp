<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>SmartSearch</title>
    <meta name="description" content="SmartSearch" />

    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="dist/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="dist/css/flat-ui.css" rel="stylesheet">
    <link href="docs/assets/css/demo.css" rel="stylesheet">

    <link rel="shortcut icon" href="img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="dist/js/vendor/html5shiv.js"></script>
      <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="container">
        <div class="demo-headline">
            <h1 class="demo-logo">
          <div class="logo"></div>
          Smart Search
          <small>A Smart Way to Find Jar Package</small>
        </h1>
        </div>
        <!-- /demo-headline -->
        <div class="col-xs-12">
            <div class="input-group">
                <input class="form-control" id="navbarInput-01" type="text" placeholder="Input Jar Package Name">
                <span class="input-group-btn">
                  <button type="button" id="searchBtn" class="btn searchBar"><span class="fui-search"></span>
                </button>
                </span>
            </div>
        </div>

        <div class="col-xs-12">
            
        </div>
    </div>
    <!-- /container -->

    <footer>
        <div class="container">
            <div class="row">
            </div>
        </div>
    </footer>
    <script>
    var pageConfig = {
        searchUrl : 'jar/search/'
    }
    </script>
    <script src="dist/js/vendor/jquery.min.js"></script>
    <script src="dist/js/flat-ui.min.js"></script>
    <script src="docs/assets/js/application.js"></script>
    <script src="dist/js/index.js"></script>
</body>

</html>
