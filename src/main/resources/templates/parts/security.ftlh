<#assign
known = Session.SPRING_SECURITY_CONTEXT??
isAdmin = false
isManagere = false
isTechnican = false
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

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUserName()
    role = user.getUserRole()
    isManagere = user.isManagere()
    >
<#else>
    <#assign
    name = "unknown"
    role = "unknown"
    isManagere = false
    >
</#if>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUserName()
    role = user.getUserRole()
    isTechnican = user.isTechnican()
    >
<#else>
    <#assign
    name = "unknown"
    role = "unknown"
    isTechnican = false
    >
</#if>