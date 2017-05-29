<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 29.05.2017
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to STARTUP project!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Startups"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Custom Theme files -->
    <link rel='stylesheet' href="<c:url value='/resources/css/bootstrap.css' />">
    <link rel='stylesheet' href="<c:url value='/resources/css/style_new.css' />">
    <link rel='stylesheet' href="<c:url value='/resources/css/smoothbox.css' />">

    <!-- //Custom Theme files -->
    <!-- js -->
    <script src="<c:url value='/resources/js/jquery.min.js' />"></script>
    <!-- //js -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
    <!-- //web font -->
</head>
<body>
<div class="w3ls-banner">
    <div class="center-container">
        <div class="navigation">
            <div class="container">
                <div class="agileits-logo">
                    <h1><a href="home">STARTUP!<span class="w3agile">The Best Startup Service</span></a></h1>
                </div>
                <div class="navigation-right">
                    <span class="menu"><img src="<c:url value='/resources/img/menu.png'/>" alt=" "/></span>
                    <nav class="link-effect-3" id="link-effect-3">
                        <ul class="nav1 nav">
                            <li class="active"><a data-hover="Home" href="home">Home</a></li>
                            <li><a data-hover="All startups" href="#allstartups" class="scroll">All startups</a></li>
                            <li><a data-hover="About" href="#about" class="scroll">About</a></li>
                            <li><a data-hover="Team" href="#team" class="scroll">Team</a></li>
                        </ul>
                    </nav>
                    <!-- script-for-menu -->
                    <script>
                        $("span.menu").click(function () {
                            $("ul.nav1").slideToggle(300, function () {
                                // Animation complete.
                            });
                        });
                    </script>
                    <!-- //script-for-menu -->
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="w3ls_banner_info">
            <div class="container">
                <div class="w3l_banner_logo">
                    <h2>SU</h2>
                </div>
                <h3>MAKE YOUR DREAM CLOSER</h3>
                <p>Find new possibilities to go UP today!</p>
                <div class="more">
                    <a href="#" class="hvr-underline-from-center" data-toggle="modal" data-target="#myModal">See
                        More</a>
                </div>
                <!-- modal-->
                <div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                More Great Startups!
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                <img src="<c:url value='/resources/img/17.jpg'/>" alt=" " class="img-responsive"/>
                                <p>Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit
                                    laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure
                                    reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel
                                    illum qui dolorem eum fugiat quo voluptas nulla pariatur.
                                    <i>" Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil
                                        molestiae consequatur.</i></p>
                            </div>
                        </div>
                    </div>
                </div> <!-- //modal-->
            </div>
        </div>
    </div>
</div>
<!-- about -->
<div class="about">
    <div class="container">
        <div class="agileits_about_grids">
            <div class="col-md-6 agileits_about_grid_left">
                <h3>What We Offer</h3>
                <p>We offer you whole startup process development: from Ideas to Final product.</p>
            </div>
            <div class="col-md-6 agileits_about_grid_right">
                <img src="<c:url value='/resources/img/16.jpg'/>" alt=" " class="img-responsive"/>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //about -->
<!-- banner-bottom -->
<div class="banner-bottom">
    <div class="container">
        <div class="col-md-4 wthree_banner_bottom_left">
            <img src="<c:url value='/resources/img/1.jpg'/>" alt=" " class="img-responsive"/>
        </div>
        <div class="col-md-8 wthree_banner_bottom_right">
            <h3>Here you can choose any project, which fits your demand</h3>
            <p>See our advantages:</p>
            <ol>
                <li>Easy to find</li>
                <li>Fast startup development</li>
                <li>Security of investments</li>
                <li>Full time customer support</li>
            </ol>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //banner-bottom -->
<!-- banner-bottom-image-text -->
<div id="about" class="banner-bottom-image-w3text">
    <div class="col-md-8 banner-bottom-image-w3text-left">
        <h3>ABOUT US</h3>
        <p>Our young team give you a great possibility to invest and search for your projects of dream!</p>
        <h4>Do not waste your time waiting! Let us act together!</h4>
    </div>
    <div class="col-md-4 banner-bottom-image-w3text-right">
        <img src="<c:url value='/resources/img/2.jpg'/>" alt=" " class="img-responsive"/>
    </div>
    <div class="clearfix"></div>
</div>
<!-- //banner-bottom-image-text -->
<!-- team -->
<div class="team" id="team">
    <div class="container">
        <h3>Meet Our Developer Team</h3>
        <p class="nostrud">The developers' team provide you 24/7 hi-end support</p>
        <div class="agile_team_grids">
            <div class="col-md-3 agile_team_grid">
                <div class="view w3-agile-view">
                    <img src="<c:url value='/resources/img/3.jpg'/>" alt=" " class="img-responsive"/>
                    <div class="w3lmask">
                        <h5>quis nostrud</h5>
                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit.</p>
                        <div class="agileits_social_icons">
                            <a href="#" class="icon-button twitter"><i class="icon-twitter"></i><span></span></a>
                            <a href="#" class="icon-button facebook"><i class="icon-facebook"></i><span></span></a>
                            <a href="#" class="icon-button google-plus"><i
                                    class="icon-google-plus"></i><span></span></a>
                        </div>
                    </div>
                </div>
                <h4>Andriy Kharyshyn</h4>
                <p>Developer</p>
            </div>
            <div class="col-md-3 agile_team_grid">
                <div class="view w3-agile-view">
                    <img src="<c:url value='/resources/img/6.jpg'/>" alt=" " class="img-responsive"/>
                    <div class="w3lmask">
                        <h5>quis nostrud</h5>
                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit.</p>
                        <div class="agileits_social_icons">
                            <a href="#" class="icon-button twitter"><i class="icon-twitter"></i><span></span></a>
                            <a href="#" class="icon-button facebook"><i class="icon-facebook"></i><span></span></a>
                            <a href="#" class="icon-button google-plus"><i
                                    class="icon-google-plus"></i><span></span></a>
                        </div>
                    </div>
                </div>
                <h4>Laura Carl</h4>
                <p>Agent</p>
            </div>
            <div class="col-md-3 agile_team_grid">
                <div class="view w3-agile-view">
                    <img src="<c:url value='/resources/img/4.jpg'/>" alt=" " class="img-responsive"/>
                    <div class="w3lmask">
                        <h5>quis nostrud</h5>
                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit.</p>
                        <div class="agileits_social_icons">
                            <a href="#" class="icon-button twitter"><i class="icon-twitter"></i><span></span></a>
                            <a href="#" class="icon-button facebook"><i class="icon-facebook"></i><span></span></a>
                            <a href="#" class="icon-button google-plus"><i
                                    class="icon-google-plus"></i><span></span></a>
                        </div>
                    </div>
                </div>
                <h4>James Cam</h4>
                <p>Agent</p>
            </div>
            <div class="col-md-3 agile_team_grid">
                <div class="view w3-agile-view">
                    <img src="<c:url value='/resources/img/5.jpg'/>" alt=" " class="img-responsive"/>
                    <div class="w3lmask">
                        <h5>quis nostrud</h5>
                        <p>Quis autem vel eum iure reprehenderit qui in ea voluptate velit.</p>
                        <div class="agileits_social_icons">
                            <a href="#" class="icon-button twitter"><i class="icon-twitter"></i><span></span></a>
                            <a href="#" class="icon-button facebook"><i class="icon-facebook"></i><span></span></a>
                            <a href="#" class="icon-button google-plus"><i
                                    class="icon-google-plus"></i><span></span></a>
                        </div>
                    </div>
                </div>
                <h4>Luther</h4>
                <p>Agent</p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //team -->
<!-- team-bottom -->
<!-- gallery -->
<div class="gallery" id="allstartups">
    <h3>ALL STARTUPS</h3>
    <p class="nostrud agileits-w3layouts">Here you can look for the startups you prefer.</p>
    <div class="w3agile_gallery_grids">
        <div class="col-md-3 w3agile_gallery_grid">
            <div class="w3agile_gallery_image">
                <a class="sb" href="<c:url value='/resources/img/8.jpg'/>"
                   title="Airport Kyiv">
                    <figure>
                        <a href="startupdetails/1"/><img src="<c:url value='/resources/img/8.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>Airport Kyiv new terminal</h4>
                            <p>
                                New Terminal T3 in the Airport Kyiv.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/9.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/9.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/10.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/10.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid w3-agileits">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/11.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/11.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid w3-agileits">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/12.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/12.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid w3-agileits">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/13.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/13.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/14.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/14.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="col-md-3 w3agile_gallery_grid">
            <div class="w3agile_gallery_image">
                <a class="sb"
                   title="quis nostrud exercitation ullamco laboris quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum"
                   href="<c:url value='/resources/img/15.jpg'/>">
                    <figure>
                        <img src="<c:url value='/resources/img/15.jpg'/>" alt="" class="img-responsive"/>
                        <figcaption>
                            <h4>dolore magna aliqua</h4>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </figcaption>
                    </figure>
                </a>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
    <script type="text/javascript" src="<c:url value='/resources/js/smoothbox.jquery2.js'/>"></script>
</div>
<!-- //gallery -->

<div class="more">
    <a href="/startups/add" class="hvr-underline-from-center" data-toggle="modal" data-target="#myModal">Add new startup</a>
</div>


<!-- bootstrap js -->
<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<!-- //bootstrap js -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="<c:url value='/resources/js/move-top.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/easing.js'/>"></script>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
        });
    });
</script>
<!-- start-smooth-scrolling -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<!-- //here ends scrolling icon -->
</body>
</html>