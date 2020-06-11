<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
<%--    <style type="text/css">@import url(css/main.css);</style>--%>
</head>
<body>
    <form action="save-product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name"
                       >
            </p>
            <p>
                <label for="description">Description: </label>
                <input type="text" id="description"
                       name="description" >
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price"
                      >
            </p>
            <p id="buttons">
                <input id="reset" type="reset" >
                <input id="submit" type="submit"
                       value="Add Product">
            </p>
        </fieldset>
    </form>
</body>
</html>
