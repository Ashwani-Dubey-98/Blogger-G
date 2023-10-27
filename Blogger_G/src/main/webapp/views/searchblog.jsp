<%@page import="com.text.blog.blog"%>
<%@page import="java.util.*"%>
<%@page import="org.hibernate.criterion.Criterion"%>
<%@page import="org.hibernate.Criteria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% List<blog> data =(List) request.getAttribute("key"); 
   Iterator<blog> it = data.iterator();
   while(it.hasNext()){ 
   blog b = (blog) it.next();
   %>
   <div class="container">
   <div class="row">
    <div class="col-12">
      <div class="card" style="border: groove; text-align: center;">
        <div style="align-self: center;"><img class="card-img img-responsive" src="img/<%=b.getPath() %>" style="height: 200px; width:80%;" alt="Bologna"></div>
        <div class="card-body rounded-top">
          <h4 class="card-title text-primary"><%= b.getTitle() %></h4>
          <p class="card-text"><%=b.getBlogtext() %></p>
        </div>
        <div class="card-footer text-muted d-flex justify-content-between bg-transparent border-top-0">
          <div class="views"><%= b.getAddeddate() %>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
   <% 
     } %>
