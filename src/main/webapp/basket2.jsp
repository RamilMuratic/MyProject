
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<style>
table, th, td {
  border:2px solid green;
}
</style>
<body style="background-color:#FFF8DC;">

<h1 style="text-align:center;">Корзина</h1>
<table style="width:50%">
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <th>Категория</th>
        <th>Размер</th>
        <th>Цвет</th>
        <th>Страна</th>
        for (int i=0; i < myBasket.size(); i++) {
                        Clothes p = myBasket.get(i);

                            response.getWriter().append("<tr>\n" +
                                    "    <td>" + p.getName() + "</td>\n" +
                                    "    <td>" + p.getCategory() + "</td> \n" +
                                    "    <td>" + p.getPrice() + "</td>\n" +
                                    "    <td><a href= \"./remove?id=" + i + "\">Remove</a></td>\n" +
                                    "  </tr>");
                    }
    </tr>
    <tr>
        <td>Alfreds Futterkiste</td>
        <td>Maria Anders</td>
        <td>Germany</td>
    </tr>
    <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
    </tr>
</table>



<div>
    <p><a href="./searchClothes.html">Поиск товара</a>  </p>
</div>

<div>
    <p><a href="./"> Назад </a>  </p>
</div>
</body>
</html>