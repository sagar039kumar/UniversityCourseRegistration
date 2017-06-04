<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
   
 <script  type ="text/javascript">

   function update()
	{
	document.productForm.action="update.do";
	document.productForm.submit();
	
	}

   function list()
	{
	document.productForm.action="list.do";
	document.productForm.submit();
	
	}

</script>
    </head>
   
    <body>
    
    <form:form name="productForm" method="post" action="save.do" modelAttribute="item">
    <input name="rollno" type="hidden" value="${item.rollno}">
        <div align="center">
            <h1>Course Registration Details</h1>
            <table border="1">
           
                <tr>
                       <th>University</th>   <td> <input name="universityName" value="${item.universityName}"></td>
                             
                </tr>
             <tr>
                       <th>Course</th>   <td> <input name="course" value="${item.course}"></td>
                             
                </tr>
             <tr>
                       <th>Student</th>   <td> <input name="student" value="${item.student}"></td>
                             
                </tr>
               <tr>
                       <th> <input type="submit" value="Add New">   </th>   <th>   <input type="button" value="Update"  onclick="update()"/> <input type="button" value="List"  onclick="list()"/></th> 
                             
                </tr>
                     
                
            </table>
        </div>

        </form:form>
        
         <div align="center">
            <h1>Student List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Roll No.</th>
                <th>University</th>
                <th>Course</th>
                <th>Student</th>
                <th>Action</th>
                <th>Action</th>
                
                
                 </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.rollno}</td>
                    <td>${item.universityName}</td>
                    <td>${item.course}</td>
                    <td>${item.student}</td>
                    <td><a href="edit.do?id=${item.rollno}">Edit</a></td>  
    				<td><a href="delete.do?id=${item.rollno}">Delete</a></td>  
                             
                </tr>
                </c:forEach>             
            </table>
        </div>             
        
    </body>
</html>