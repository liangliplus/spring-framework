package indi.kenneth.propetysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author liangll
 * @Date 2023/4/14
 */
@Component
public class PropertiesDemo {
	@Value("${cn.username}")
	String username;
}
