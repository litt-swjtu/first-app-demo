package com.swjtu.firstappdemo.config;

import com.swjtu.firstappdemo.repository.UserRepository;
import com.swjtu.firstappdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数 配置
 * @author 李天峒
 * @date 2019/5/30 23:17
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *   请求接口：ServletRequest 或者 HttpServletRequest
     *   响应接口：ServletResponse 或者 HttpServletResponse
     * Spring 5.0 重新定义了服务请求和响应接口
     *   请求接口：ServerRequest
     *   响应接口：ServerResponse
     *   既可以支持 Servlet 规范，也可以支持自定义的，比如 Netty（Web Server）
     *
     * 以本例：
     *   定义 GET 请求，并且返回所有的用户对象  URI：/person/find/all
     * flux 是 0 - N 个对象集合
     * Mono 是 0 - 1 个对象集合
     * Reactive 中的 flux 或者 Mono 它是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     */

    /**
     * 之所以采用这种方式，是因为reactive是异步处理非阻塞的方式，可以提高程序的吞吐量
     * @param userRepository
     * @return
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    // 返回所有用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
