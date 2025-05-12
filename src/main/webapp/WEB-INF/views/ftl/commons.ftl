

<!DOCTYPE html>
<html>
<head>
    <title>Commons Page</title>
</head>
<body>
    <h2>Login Info</h2>

    <#if lastCar.make?? && lastCar.model??>
        <p>Your username is: <b>${lastCar.make}</b></p>
        <p>Your password is: <b>${lastCar.model}</b></p>
    <#else>
        <p>No login info submitted.</p>
    </#if>
</body>
</html>



  
<#--  <p>Testing is a property exists: ${student???c}</p>
<#if status??>
    <p>Property value: ${status.reason}</p>
<#else>
    <p>Missing property</p>
</#if>

<p>Iterating a sequence:</p>
<#list statuses>
    <ul>
        <#items as status>
        <li>${status}</li>
    </#items>
    </ul>
    <#else>
    <p>No statuses available</p>
</#list>

<p>Using static methods</p>
<#assign MathUtils=statics['java.lang.Math']>
<p>PI value: ${MathUtils.PI}</p>
<p>2*10 is: ${MathUtils.pow(2, 10)}</p>

<p>Using bean method</p>
<p>Random value: ${random.nextInt()}</p>

<p>Use custom method</p>
<p>Last char example: ${lastChar('mystring')}</p>  -->
