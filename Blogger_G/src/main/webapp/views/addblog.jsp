<%@include file="header.jsp" %>
<!--  This is Form. -->
<div class="container" style="padding-top: 10px;">
<div class="row container">
  <div class="column col-sm-2 text-success"><b>${blog_added}</b></div>
  <div class="column col-sm-8">
 
 <form action="addbloglogic.do" method="post" enctype="multipart/form-data">
  <div class="form-group row">
    <label for="inputTitle" class="col-sm-2 col-form-label">Title</label>
    <div class="col-sm-10">
         <input type="text" name="title" class="form-control" id="inputEmail3" placeholder="Title" required="required">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputTitle" class="col-sm-2 col-form-label">File</label>
    <div class="col-sm-10">
         <input type="file" name="file" class="form-control" id="inputEmail3">
    </div>
  </div>

  <div class="form-group row">
    <label for="inputBlog" class="col-sm-2 col-form-label">Blog</label>
     <div class="col-sm-10">
         <textarea name="blogtext" class="form-control"  required="required" maxlength="500" rows="15" id="Blog" placeholder="Want to share your thought, experience, information or anything else....."></textarea>
     </div>
  </div>
  <div class="form-group row">
    <div class="column col-sm-2"></div>
    <div class="column col-sm-10" style="text-align:center;">
      <button type="submit" class="btn btn-primary col-sm-10" required="required">Post</button>
    </div>
  </div>
 </form>
 </div>  
 </div> 
    <div class="column col-sm-2"></div>
</div>
</body>
</html>