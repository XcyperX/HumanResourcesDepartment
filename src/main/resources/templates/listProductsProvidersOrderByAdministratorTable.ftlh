<#import "parts/common.ftlh" as c>
<#import "parts/listProductsCard.ftlh" as lpc>
<#import "parts/listProductsTable.ftlh" as lpt>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/filteredBlock.ftlh" as fb>
<#import "parts/searchBlock.ftlh" as sb>
<#import "parts/listProductsTableDeliveries.ftlh" as lptd>


<@c.page>
    <div class="container">
        <@lptd.listProducts providers=providers products=products categories=categories manufacturer=manufacturer/>
    </div>
</@c.page>