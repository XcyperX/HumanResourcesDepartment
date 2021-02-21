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
                        <a href="#" class="btn btn-primary btn-block">Добавить в корзину</a>
                    </div>
                </div>
            </div>
        <#--            <div class="col mb-4">-->
        <#--                &lt;#&ndash;<div class="card" style="max-width: 650px;">&ndash;&gt;-->
        <#--                <div class="card">-->
        <#--                    <div class="row no-gutters">-->
        <#--                        <div class="col-md-5">-->
        <#--                            <img src="/img/${product.urlPhoto}" class="card-img" alt="...">-->
        <#--                        </div>-->
        <#--                        <div class="col-md-7">-->
        <#--                            <div class="card-body">-->
        <#--                                <h5 class="card-title"><#list categories as categori>-->
        <#--                                        <#if categori.id == product.categoriesId>-->
        <#--                                            ${categori.name}-->
        <#--                                        </#if>-->
        <#--                                    </#list> ${product.name}</h5>-->
        <#--                                <p class="card-text">${product.description}</p>-->
        <#--                                &lt;#&ndash;<p class="card-text">&ndash;&gt;-->
        <#--                                &lt;#&ndash;<small class="text-muted">Last updated 3 mins ago</small>&ndash;&gt;-->
        <#--                                &lt;#&ndash;</p>&ndash;&gt;-->
        <#--                            </div>-->
        <#--                            <div class="card-footer" style="width: 100%; bottom: 0px; position: absolute;">-->
        <#--                                <h5 class="modal-title">${product.price} р.</h5>-->
        <#--                                <a href="#" class="btn btn-primary btn-block">Добавить в корзину</a>-->
        <#--                            </div>-->
        <#--                        </div>-->
        <#--                    </div>-->
        <#--                </div>-->
        <#--            </div>-->
        <#--<div class="col mb-4">-->
        <#--<div class="form-row">-->
        <#--<div class="card" style="width: 18rem;">-->
        <#--<img src="/img/${product.urlPhoto}" class="card-img-top" alt="...">-->
        <#--<div class="card-body">-->
        <#--<h5 class="card-title"><#list categories as categori>-->
        <#--<#if categori.id == product.categoriesId>-->
        <#--${categori.name}-->
        <#--</#if>-->
        <#--</#list> ${product.name}</h5>-->
        <#--<p class="card-text">${product.description}</p>-->
        <#--<hr>-->
        <#--<p class="card-text">${product.structure}</p>-->
        <#--<a href="#" class="btn btn-primary">Заказать</a>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        <#--</div>-->
        </#list>
    </#if>
</#macro>
