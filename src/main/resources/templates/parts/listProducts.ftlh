<#macro listPruduct products categories administrator=false guest=false>
    <#if products?has_content>
        <div class="row row-cols-1 row-cols-md-3">
            <#list products as product>
                <div class="col mb-4">
                    <div class="form-row">
                        <div class="card" style="width: 18rem;">
                            <img src="/img/${product.urlPhoto}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <p class="card-text">${product.description}</p>
                                <hr>
                                <p class="card-text">${product.structure}</p>
                                <a href="#" class="btn btn-primary">Заказать</a>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </#if>
</#macro>