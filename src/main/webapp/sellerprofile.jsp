<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<%@page import="model.Seller"%>
<%@page import="model.customermodel"%>
<html lang="zxx">

<head>
    <title>Bootie Ecommerce Bootstrap Responsive Web Template | Contact :: W3layouts</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content="Bootie Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script>
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta tag Keywords -->

    <!-- Custom-Files -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Bootstrap-Core-CSS -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <!-- font-awesome-icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!-- //font-awesome-icons -->
    <!-- /Fonts -->
    <link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">
    <!-- //Fonts -->

</head>

<body>
<%Seller s = null;
if(session.getAttribute("data")!=null){
	s = (Seller)session.getAttribute("data");
}
else{
	response.sendRedirect("sellerlog.jsp");
}
%> 

    <!-- mian-content -->
    <div class="main-banner inner" id="home">
        <!-- header -->
        <header class="header">
            <div class="container-fluid px-lg-5">
                <!-- nav -->
                <nav class="py-4">
                    <div id="logo">
                        <h1> <a href="Index.jsp"><span class="fa fa-bold" aria-hidden="true"></span>ootie</a></h1>
                    </div>
                    <label for="drop" class="toggle">Menu</label>
                    <input type="checkbox" id="drop" />
                    <ul class="menu mt-2">
                        <!-- <li><a href="Index.jsp">Home</a></li> -->
                        <li>
                            <!-- First Tier Drop Down -->
                            <label for="drop-2" class="toggle">Drop Down <span class="fa fa-angle-down" aria-hidden="true"></span> </label>
                            <a href="#">PROFILE <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                                <li><a href="sellerchangepassword.jsp">CHANGE PASSWORD</a></li>
                                <li><a href="Logout.jsp">LOGOUT</a></li>
                                
                            </ul>
                        </li>
                    </ul>

                   <label for="drop" class="toggle">Menu</label>
                    <input type="checkbox" id="drop" />
                    <ul class="menu mt-2">
                       <li><a href="sellerindex.jsp">Home</a></li>
                        <li>
                            <!-- First Tier Drop Down -->
                            <label for="drop-2" class="toggle">Drop Down <span class="fa fa-angle-down" aria-hidden="true"></span> </label>
                           <!--  <a href="#">VARIOUS PRODUCTS <span class="fa fa-angle-down" aria-hidden="true"></span></a>
                            <input type="checkbox" id="drop-2" />
                            <ul>
                                <li><a href="shoes.jsp">SHOES</a></li>
                                <li><a href="jersey.jsp">JERSEY</a></li>
                            </ul> -->
                        </li>
                    </ul>
                    
                    
                    
                </nav>
                <!-- //nav -->
            </div>
        </header>
        <!-- //header -->

    </div>
    <!--//main-content-->
    <!---->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="customerindex.jsp">HOME</a>
        </li>
        <li class="breadcrumb-item active">SELLER PROFILE</li>
    </ol>
    <!---->
    <!--// mian-content -->
    <!-- banner -->
    <section class="ab-info-main py-5">
        <div class="container py-3">
            <h3 class="tittle text-center"><span class="sub-tittle"></span>SELLER PROFILE</h3>
            <div class="row contact-main-info mt-5">
                <div class="col-md-12 contact-right-content">
                    <form action="Sellercontroller" method="post">
                        <input type="hidden" name="ID"  value=<%= s.getID() %>> 
                        <input type="text" name="yourname" value=<%= s.getyourname() %> required="">
                        <input type="email" class="email" name="email" value="<%= s.getemail() %>" required="">
                        <input type="text" name="phone" placeholder="phone" value="<%= s.getphone() %>" required="">
                        <div class="text-center mt-3">
                            <input type="Submit" value="update" name ="action" >
                        </div>
                    </form>
                </div>
               
                <!-- <div class="col-md-6 contact-left-content">
                    <div class="address-con">
                        <h4 class="mb-2"><span class="fa fa-phone-square" aria-hidden="true"></span> Phone</h4>
                        <p>+121 098 8907 9987</p>
                        <p>+121 098 8907 9987</p>
                    </div>
                    <div class="address-con my-4">
                        <h4 class="mb-2"><span class="fa fa-envelope-o" aria-hidden="true"></span> Email </h4>
                        <p><a href="mailto:info@example.com">info@example.com</a></p>
                        <p><a href="mailto:info@example.com">info@example.com</a></p>
                    </div>
                    <div class="address-con mb-4">
                        <h4 class="mb-2"><span class="fa fa-fax" aria-hidden="true"></span> Fax</h4>

                        <p>(800) 123-80088</p>
                    </div>
                    <div class="address-con">
                        <h4 class="mb-2"><span class="fa fa-map-marker" aria-hidden="true"></span> Location </h4>

                        <p>Honey Avenue, New York City</p>
                    </div>

                </div>

            </div>
            <div class="map-fo mt-lg-5 mt-4">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d423286.27404345275!2d-118.69191921441556!3d34.02016130939095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2c75ddc27da13%3A0xe22fdf6f254608f4!2sLos+Angeles%2C+CA%2C+USA!5e0!3m2!1sen!2sin!4v1522474296007" allowfullscreen></iframe>
            </div>
        </div> -->
    </section>


    <!-- //contact -->
    <!-- footer -->
</body>

</html>
s