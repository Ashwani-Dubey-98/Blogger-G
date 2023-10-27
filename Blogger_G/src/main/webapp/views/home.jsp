  <script>
    function searchblog(a) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
    	document.getElementById("res").innerHTML = xmlhttp.responseText;
	}
    xmlhttp.open("POST","searchblog.do?q="+a,true);
    xmlhttp.send();
    }
  </script>
      <%@include file="header.jsp"%>
    <div class="row">
		<div class="column col-sm-2" style="border: 2px; float: left;"></div>
        <div class="container column col-sm-8 m-auto" style="text-align: center;">
		   <form class="form-inline">
			 <input class="form-control" style="width:90%" type="search" placeholder="Search Blogs" id="search" onkeyup="searchblog(this.value)" />
	       </form>
	       <br><br>
	       <div id="res"></div>
        </div>
        <div class="column col-sm-2" style="float: right;"></div>
    </div>
 </body>
</html>