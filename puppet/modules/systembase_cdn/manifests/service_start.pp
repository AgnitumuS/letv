class systembase_cdn::service_start{
  service{ "crond":
    ensure     => running,
    enable     => true,
  }
}