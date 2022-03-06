<!DOCTYPE html>

<html lang="en">
<head>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Manrope:wght@300&display=swap" rel="stylesheet">

      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<style type="text/css">

* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: 'Manrope', sans-serif;
}

body {
    height: 100%;
    padding-bottom:65px;
}

.topnav {
    background: black;
    height: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.2em;
    position: sticky;
    top: 0;
    z-index: 999;
}

.topnav_container {
    display: flex;
    justify-content: space-between;
    height: 80px;
    z-index: 1;
    width: 100%;
    max-width: 1300px;
    margin: 0 auto;
    padding: 0 50px;
}

#topnav_logo {
    background-color:  cyan;
    background-size: 100%;
    -webkit-background-clip: text;
    -moz-background-clip: text;
    -webkit-text-fill-color: transparent;
    -moz-text-fill-color: transparent;
    display: flex;
    align-items: center;
    cursor: pointer;
    text-decoration: none;
    font-size: 2rem;
}
.fa-gem{
    margin-right: 0.5rem;
}

.topnav_menu {
    display: flex;
    top: 50%;
    bottom: 50%;
    transform: translate(0%, .5rem);
    align-items: center;
    list-style: none;
    text-align: center;
}

.topnav_item {
    height: 70px;
}

.topnav_links {
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    text-decoration: none;
    padding: 0 1rem;
    height: 100%;
}
.topnav_btn {
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0 1rem;
    width: 100%;
}
.button {
    display: flex;
    justify-content: center;
    align-items: center;
    text-decoration: none;
    padding: 10px 10px;
    height: 100%;
    width: 100%;
    border: none;
    outline: none;
    border-radius: 5px;
    background: orangered;
    color: white;
}

.button:hover {
    background: cyan;
    transition: all 0.3s ease;
}

.topnav_links:hover {
    color: cyan;
    transition: all 0.3s ease;
}

@media screen and (max-width: 700px) {
    .topnav_container {
        display: flex;
        justify-content: space-between;
        height: 80px;
        z-index: 1;
        width: 100%;
        max-width: 1300px;
        padding: 0;
    }
    .topnav_menu {
        display: grid;
        grid-template-columns: auto;
        justify-content: center;
        margin: 0;
        position: absolute;
        /* top: -1000px;
        opacity: 0; */
        transition: all 0.2s ease;
        transform: none;
        height: 80vh;
        width: 45rem;
        z-index: -1;
        background: black;
    }
    .topnav_menu.active {
        background: black;
        top: 100%;
        opacity: 1;
        transition: all 0.5s ease;
        z-index: 99;
        height: 50vh;
        font-size: 1.6rem;
    }
    #topnav_logo {
        padding-left: 25px;
    }
    .topnav_toggle .bar {
        width: 25px;
        height: 3px;
        margin: 5px auto;
        transition: all 0.3s ease-in-out;
        background: white;
    }
    .topnav_links {
        text-align: center;
        padding: 2rem;
        width: 100%;
        display: table;
    }
    #mobile-menu {
        position: absolute;
        top: 20%;
        right: 5%;
        transform: translate(5%, 20%);
    }
    .topnav_item {
        width: 100%;
        padding-bottom: 2rem;
    }
    .button {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 80px;
        margin: 0;
    }
    .topnav_toggle .bar {
        display: block;
        cursor: pointer;

    }
    #mobile-menu.is-active .bar:nth-child(2){
        opacity: 0;
    }
    #mobile-menu.is-active .bar:nth-child(1){
        transform: translateY(8px) rotate(45deg);
    }
    #mobile-menu.is-active .bar:nth-child(3){
        transform: translateY(-8px) rotate(45deg);
    }
}
.footer-basic {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    padding:10px 0;
    background-color:#ffffff;
    color:#4b4c4d;
}

.footer-basic ul {
    padding:0;
    list-style:none;
    text-align:center;
    font-size:14px;
    line-height:1.6;
    margin-bottom:0;
}

.footer-basic li {
    padding:0 10px;
}

.footer-basic ul a {
    color:inherit;
    text-decoration:none;
    opacity:0.8;
}

.footer-basic ul a:hover {
    opacity:1;
}

.footer-basic .social {
    text-align:center;
    padding-bottom:10px;
}

.footer-basic .social > a {
    font-size:12px;
    width:35px;
    height:35px;
    line-height:35px;
    display:inline-block;
    text-align:center;
    border-radius:50%;
    border: 1px solid #ccc;
    margin:0 8px;
    color:inherit;
    opacity:0.75;
}

.footer-basic .social > a:hover {
    opacity:0.9;
}

.footer-basic .copyright {
    margin-top:14px;
    text-align:center;
    font-size:13px;
    color:#aaa;
    margin-bottom:0;
}

</style>

</head>
<body>
  <nav id="common-nav">
        <nav class="topnav">
          <div class="topnav_container">
            <a href="/" id="topnav_logo">Bike Find</a>
            <div class="topnav_toggle" id="mobile-menu">
              <span class="bar"></span><span class="bar"></span>
              <span class="bar"></span>
            </div>
            <ul class="topnav_menu">
              <li class="topnav_item">
                <a href="/index" class="topnav_links"> Home </a>
              </li>

              <li class="topnav_item">
                <a href="/inventory" class="topnav_links"> Inventory </a>
              </li>

              <sec:authorize access="hasAuthority('ADMIN')">
              <li class="topnav_item">
                 <a href="/productList" class="topnav_links"> Product Search </a>
              </li>

                </sec:authorize>
              <li class="topnav_item">
              <sec:authorize access="!isAuthenticated()">
                <a href="/register" class="button"> Sign Up </a>
                </sec:authorize>

              </li>
              <sec:authorize access="!isAuthenticated()">
                    <li><a href="/login/login">Sign In</a></li>
              </sec:authorize>

              <sec:authorize access="isAuthenticated()">
                    <li><a href="/login/logout">Logout</a></li>
              </sec:authorize>

               <sec:authorize access="hasAuthority('ADMIN')">
                    <li><a href="/createProduct">Create Product</a></li>
              </sec:authorize>


              <li class="topnav_item">
                <a href="/mycart" class="topnav_links"> My Cart </a>
              </li>
            </ul>
          </div>
        </nav>
      </nav>

