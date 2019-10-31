<@compress single_line=true>
{
"meta": {<#if message?has_content>"message": "${message?js_string!}",</#if> 
         <#if code?has_content>"code": "${code!}",</#if> 
         "success": ${success?c}, 
         <#if page_total?has_content>"page": {"total": ${page_total}, "current": ${page_current}},</#if> 
         "ts": ${.now?long}}, 
"data": ${page_content}
}
</@compress>