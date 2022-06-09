
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body style="background-color:#FFF8DC;">

<h1 style="text-align:center;">Basket</h1>

<%  if(request.getSession() = 0){
 out.Print("Your basket is empty")
 } else { out.Print("Add clothes to basket")
 }

 %>


<div>
    <p><a href="./searchClothes.html">Поиск товара</a>  </p>
</div>

<div>
    <p><a href="./"> Назад </a>  </p>
</div>
</body>
</html>