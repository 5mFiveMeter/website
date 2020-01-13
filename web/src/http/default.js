import Axios from 'axios';

Axios.defaults.timeout = 5000;
Axios.defaults.baseURL = 'http://localhost:8090'

//http request 拦截器
Axios.interceptors.request.use(config => {
    return config;
  }, error => {
    return error;
  }
);

//http response 拦截器
Axios.interceptors.response.use(response => {
    if(response.status == 200){
        return response.data;
    }else {
      return {
        code:555,
        msg:"网络链接失败"
      }
    }

  }, error => {
    return error;
  }
)

export default Axios;



