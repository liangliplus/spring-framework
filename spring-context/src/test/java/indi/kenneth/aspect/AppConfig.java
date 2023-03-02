package indi.kenneth.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kenneth
 * @Date: 2023/3/1
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan("indi.kenneth.aspect")
public class AppConfig {
}
