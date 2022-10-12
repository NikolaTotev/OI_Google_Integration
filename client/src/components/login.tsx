import { GoogleLogin } from "@react-oauth/google";



const Login = () => {
    return( <div id="btn_login">
        <GoogleLogin
            onSuccess={credentialResponse => {
                console.log(credentialResponse);
            }}
            onError={() => {
                console.log('Login Failed');
            }}
        />
    </div>);
}

export default Login;