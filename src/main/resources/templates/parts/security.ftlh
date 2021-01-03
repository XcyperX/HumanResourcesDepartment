<#assign
known = Session.SPRING_SECURITY_CONTEXT??
isAdmin = false
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUserName()
    role = user.getUserRole()
    isAdmin = user.isAdmin()
    >
<#else>
    <#assign
    name = "unknown"
    role = "unknown"
    isAdmin = false
    >
</#if>