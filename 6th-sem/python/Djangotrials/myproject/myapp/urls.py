from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index, name = 'index'),
    url(r'^post_url/$', views.post_resume, name = 'post_resume'),
    url(r'^show/$', views.show, name = 'show'),
]
