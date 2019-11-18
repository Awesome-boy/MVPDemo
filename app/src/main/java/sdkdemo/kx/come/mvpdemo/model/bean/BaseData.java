package sdkdemo.kx.come.mvpdemo.model.bean;

import com.corelibs.subscriber.ResponseHandler;

import java.io.Serializable;

public class BaseData<T> implements Serializable,ResponseHandler.IBaseData {

    public int code;
    public String mess;
    public T data;


    @Override
    public boolean isSuccess() {
        return code==1;
    }



    @Override
    public int status() {
        return code;
    }

    @Override
    public Object data() {
        return data;
    }

    @Override
    public String msg() {
        return mess;
    }
}
