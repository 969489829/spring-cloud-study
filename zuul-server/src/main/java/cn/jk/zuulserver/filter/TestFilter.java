package cn.jk.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author jk
 * @date 2019/3/25 18:03
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
public class TestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //过滤器排序，一般-1便是排在哪个之前
        return  FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //prefilter
        // a filter has already forwarded
        return !ctx.containsKey(FilterConstants.FORWARD_TO_KEY)
                // a filter has already determined serviceId
                && !ctx.containsKey(FilterConstants.SERVICE_ID_KEY);

        //route filter
//        return RequestContext.getCurrentContext().getRouteHost() != null
//                && RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k,v) -> {
            System.out.println("key:" + k + ",value:" + v[0]);
        });
        return null;
    }
}
