<#macro listPruduct products categories administrator=false guest=false>
    <#if products?has_content>
        <#list products as product>
            <div class="col mb-4" id="product_${product.id}">
                <div class="card h-100">
                    <div class="card-body pb-0">
                        <img src="data:image/jpg;base64,${product.base64Image}" class="card-img-top rounded mx-auto d-block" alt="..."
                             style="width: 60%;">
                    </div>
                    <div class="card-body">
                        <h6 class="card-title mb-0">${product.name}</h6>
                    </div>
                    <div class="card-footer">
                        <h5 class="modal-title mb-2">${product.price} р.</h5>
                        <div class="row">
                            <input id="amount_product_${product.id}" type="text" name="amount_product_${product.id}" class="form-control col-7 mr-2"
                                   placeholder="Количество"
                                   value="">
                            <button class="btn btn-primary btn-block col" onclick="addProductInDeliveries(${product.userId}, ${product.id}, 'customerBasket')">
                                Добавить
                            </button>
                        </div>

                    </div>
                </div>
            </div>
        </#list>
    </#if>
</#macro>
