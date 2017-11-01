<#ftl encoding= 'UTF-8'>
<#import "spring.ftl" as spring />
<@spring.bind "model" />

<body>
<table>
    <tr>
        <th>ID</th>
        <th>Модель</th>
        <th>Номер</th>
        <th>Цвет</th>
        <th>Имя владельца</th>
    </tr>
<#list model.autos as auto>
    <tr>
        <td>${auto.id}</td>
        <td>${auto.model}</td>
        <td>${auto.number}</td>
        <td>${auto.color}</td>
        <td>${auto.owner.name}</td>
    </tr>
</#list>
</table>
<form action="/autos" method="post">
    <label>Модель</label>
    <input name="model"/>
    <label>Номер</label>
    <input name="number"/>
    <label>Цвет</label>
    <input name="color"/>
    <label>ID владельца</label>
    <input name="ownerId"/>
    <input type="submit">
</form>
</body>