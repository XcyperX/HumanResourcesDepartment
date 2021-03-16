<#import "parts/common.ftlh" as c>
<#import "parts/listEmployees.ftlh" as le>
<#import "parts/listSubdivision.ftlh" as sb>
<#import "parts/listPositionNames.ftlh" as pn>
<#import "parts/createProducts.ftlh" as p>
<#import "parts/listStore.ftlh" as store>
<#import "parts/listManufaturer.ftlh" as man>
<#import "parts/createEmployee.ftlh" as ce>

<@c.page>
    <div class="container">
        <div class="row mb-2">
            <div class="col pl-0">
                <p class="text-justify">Количество покупателей: ${countCustomer}</p>
                <span>Сортировать: </span>
                <button type="button" class="btn btn-light btn-sm">По алфавиту</button>
            </div>
        </div>
        <div class="row">
            <@le.listEmployees employees=employees subdivisions="" positionsNames="" genders="" isCustomer=true/>
        </div>
    </div>
</@c.page>