package app.security;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author J. Kazakovs
 *
 */
@Component
@Scope( "request" )
public class LoginBean
	{
	 private String username = "";
    private String password = "";
    private boolean rememberMe = false;
    private boolean loggedIn = false;

	/**
	 * @return
	 * @throws java.io.IOException
	 * @throws javax.servlet.ServletException
	 */


    public String doLogin() throws IOException, ServletException
    {

        return null;

    }
	/**
	 * @return
	 */
	public String getUsername ( )
		{
		return this.username;
		}

	/**
	 * @param username
	 */
	public void setUsername ( final String username )
		{
		this.username = username;
		}

	/**
	 * @return
	 */
	public String getPassword ( )
		{
		return this.password;
		}

	/**
	 * @param password
	 */
	public void setPassword ( final String password )
		{
		this.password = password;
		}

	/**
	 * @return
	 */
	public boolean isLoggedIn ( )
		{
		return this.loggedIn;
		}

	/**
	 * @param loggedIn
	 */
	public void setLoggedIn ( final boolean loggedIn )
		{
		this.loggedIn = loggedIn;
		}

	private static Logger logger = Logger.getLogger ( LoginBean.class );
	}
