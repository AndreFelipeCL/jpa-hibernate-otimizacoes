package br.com.caelum;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.caelum.dao.CategoriaDao;
import br.com.caelum.dao.LojaDao;
import br.com.caelum.dao.ProdutoDao;
import br.com.caelum.model.Categoria;
import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.caelum")
@EnableTransactionManagement
public class Configurador extends WebMvcConfigurerAdapter {

	/**
	 * M�todo respons�vel por retorar uma instancia de {@link OpenEntityManagerInViewInterceptor} para que 
	 * a mesma sess�o do {@link EntityManager} dure por toda a request da JSP fazendo uso adequado do modo LAZY
	 * do Hibernate. 
	 * @return {@link OpenEntityManagerInViewInterceptor}
	 */
	@Bean
	public OpenEntityManagerInViewInterceptor getOpenEntityManagerInViewInterceptor() {
		return new OpenEntityManagerInViewInterceptor();
	}

	/**
	 * Registra um Interceptor de Filtro ao SpringMVC para que o mesmo entenda que este filtro deve
	 * durar todo o cilco de vida da request.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addWebRequestInterceptor(getOpenEntityManagerInViewInterceptor());
	}

	@Bean
	@Scope("request")
	public List<Produto> produtos(ProdutoDao produtoDao) {
		List<Produto> produtos = produtoDao.getProdutos();

		return produtos;
	}

	@Bean
	public List<Categoria> categorias(CategoriaDao categoriaDao) {
		List<Categoria> categorias = categoriaDao.getCategorias();

		return categorias;
	}

	@Bean
	public List<Loja> lojas(LojaDao lojaDao) {
		List<Loja> lojas = lojaDao.getLojas();

		return lojas;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setCacheSeconds(1);
		messageSource.setDefaultEncoding("ISO-8859-1");

		return messageSource;

	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		viewResolver.setExposeContextBeansAsAttributes(true);

		return viewResolver;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new Converter<String, Categoria>() {

			@Override
			public Categoria convert(String categoriaId) {
				Categoria categoria = new Categoria();
				categoria.setId(Integer.valueOf(categoriaId));

				return categoria;
			}

		});
	}

}
