<#assign
known = Session.SPRING_SECURITY_CONTEXT??
isAdmin = false
isProvider = false
isSeller = false
isStorekeeper = false
name = ""
role = ""
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    >
    <#if user.isAdmin()>
        <#assign
        isAdmin = user.isAdmin()
        name = user.getUserName()
        role = user.getUserRole()
        >
    <#elseif user.isProvider()>
        <#assign
        isProvider = user.isProvider()
        name = user.getNameFirm()
        role = user.getUserRole()
        >
    <#elseif user.isSeller()>
        <#assign
        isSeller = user.isSeller()
        name = user.getUserName()
        role = user.getUserRole()
        >
    <#elseif user.isStorekeeper()>
        <#assign
        isStorekeeper = user.isStorekeeper()
        name = user.getUserName()
        role = user.getUserRole()
        >
    </#if>
<#else>
    <#assign
    name = ""
    role = ""
    isAdmin = false
    >
</#if>

<#--<#if known>-->
<#--<#assign-->
<#--user = Session.SPRING_SECURITY_CONTEXT.authentication.principal-->
<#--isAdmin = user.isAdmin()-->
<#--name = user.getUserName()-->
<#--role = user.getUserRole()-->
<#-->-->
<#--<#else>-->
<#--<#assign-->
<#--name = ""-->
<#--role = ""-->
<#--isAdmin = false-->
<#-->-->
<#--</#if>-->

<#--<#if known>-->
<#--<#assign-->
<#--user = Session.SPRING_SECURITY_CONTEXT.authentication.principal-->
<#--isProvider = user.isProvider()-->
<#--name = user.getNameFirm()-->
<#--role = user.getUserRole()-->
<#-->-->
<#--<#else>-->
<#--<#assign-->
<#--name = ""-->
<#--role = ""-->
<#--isProvider = false-->
<#-->-->
<#--</#if>-->

<#--<#if known>-->
<#--<#assign-->
<#--user = Session.SPRING_SECURITY_CONTEXT.authentication.principal-->
<#--isSeller = user.isSeller()-->
<#--name = user.getUserName()-->
<#--role = user.getUserRole()-->
<#-->-->
<#--<#else>-->
<#--<#assign-->
<#--name = ""-->
<#--role = ""-->
<#--isSeller = false-->
<#-->-->
<#--</#if>-->

<#--<#if known>-->
<#--<#assign-->
<#--user = Session.SPRING_SECURITY_CONTEXT.authentication.principal-->
<#--isStorekeeper = user.isStorekeeper()-->
<#--name = user.getUserName()-->
<#--role = user.getUserRole()-->
<#-->-->
<#--<#else>-->
<#--<#assign-->
<#--name = ""-->
<#--role = ""-->
<#--isStorekeeper = false-->
<#-->-->
<#--</#if>-->