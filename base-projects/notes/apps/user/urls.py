from django.urls import path
from . import views

urlpatterns = [
    path('', views.user_list, name='user_list'),
    path('login/', views.login_func, name='login'),
    path('me/', views.user_me, name='user_me'),
    path('create/', views.user_create, name='user_create'),
    path('<int:pk>/delete/', views.user_delete, name='user_delete'),
]
