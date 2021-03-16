<#macro listPruduct products categories administrator=false guest=false>
    <#if products?has_content>
        <#list products as product>
            <div class="col mb-4">
                <div class="card h-100">
                    <div class="card-body pb-0">
                        <img src="/img/${product.urlPhoto}" class="card-img-top rounded mx-auto d-block" alt="..."
                             style="width: 60%;">
                    </div>
                    <div class="card-body">
                        <h6 class="card-title mb-0">${product.name}</h6>
                    </div>
                    <div class="card-footer">
                        <h5 class="modal-title mb-2">${product.price} р.</h5>
                        <button class="btn btn-primary btn-block" onclick="addProductsInBasket(${product.id})">Добавить
                            в корзину
                        </button>
                    </div>
                </div>
            </div>
        </#list>
    </#if>
</#macro>
