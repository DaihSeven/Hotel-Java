package DBarbosa.infraestrutura.security;

import DBarbosa.dominio.usuario.UsuarioRepository;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

        if(tokenJWT != null){
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }



        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {

        var authorizarionHeader = request.getHeader("Authorization");

        if(authorizarionHeader != null){

            return authorizarionHeader.replace("Bearer ", "");

        }

        return null;


    }
}
