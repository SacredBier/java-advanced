package com.soft1841;

public class Proxy implements Subject {
    @Override
    public void byMac() {
        RealSubject realSubject = new RealSubject();

        realSubject.byMac();

        this.WrapMac();
    }

    public void WrapMac(){
        System.out.println("用盒子包装好Mac");
    }
}
